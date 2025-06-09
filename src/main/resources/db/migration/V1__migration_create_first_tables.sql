-- TABELAS PRINCIPAIS

CREATE TABLE `t_clientes`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `cidade` VARCHAR(255) NOT NULL,
    `uf` VARCHAR(2) NOT NULL,
    `cnpj_ou_cpf` VARCHAR(18) NOT NULL,
    `telefone` VARCHAR(15) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `endereco` VARCHAR(255) NOT NULL,
    `tipo` ENUM('PF', 'PJ') NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `t_profissionais`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `cidade` VARCHAR(255) NOT NULL,
    `uf` VARCHAR(2) NOT NULL,
    `profissao` ENUM('medico','enfermeiro','tecnico','socorrista','bombeiro','condutor') NOT NULL,
    `n_conselho` VARCHAR(20) NOT NULL,
    `cnh` VARCHAR(11) NULL,
    `validade_cnh` DATE NULL,
    `cpf` VARCHAR(14) NOT NULL,
    `rg` VARCHAR(12) NOT NULL,
    `pix` VARCHAR(255) NOT NULL,
    `status` BOOLEAN NOT NULL DEFAULT TRUE,
    `contrato` ENUM('CLT','PJ','Autônomo','Temporário') NOT NULL,
    `validade_contrato` DATE NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `t_veiculos`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `identificacao` VARCHAR(50) NOT NULL,
    `renavam` VARCHAR(11) NOT NULL,
    `placa` VARCHAR(7) NOT NULL,
    `tipo_ambulancia` ENUM('UTI','Remoção','Suporte Básico','Outro') NOT NULL,
    `status` ENUM('ativo','manutencao','inativo') NOT NULL DEFAULT 'ativo',
    `quilometragem` BIGINT NOT NULL DEFAULT 0,
    `ultima_manutencao` DATE NULL,
    `proxima_manutencao` DATE NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY `uk_veiculo_placa` (`placa`)
);

CREATE TABLE `t_servicos`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `codigo` VARCHAR(20) NOT NULL,
    `descricao` VARCHAR(255) NOT NULL,
    `tipo` ENUM('consulta','exame','remocao','evento','outros') NOT NULL,
    `valor_padrao` DECIMAL(10, 2) NOT NULL,
    `duracao_media` INT NULL COMMENT 'Em minutos',
    `requer_veiculo` BOOLEAN NOT NULL DEFAULT FALSE,
    `ativo` BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE KEY `uk_servico_codigo` (`codigo`)
);

CREATE TABLE `t_contratos`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `cliente_id` BIGINT UNSIGNED NOT NULL,
    `numero_contrato` VARCHAR(50) NOT NULL,
    `tipo` ENUM('SUS','Particular','Convênio','Evento') NOT NULL,
    `data_inicio` DATE NOT NULL,
    `data_fim` DATE NOT NULL,
    `valor_mensal` DECIMAL(12, 2) NULL,
    `status` ENUM('ativo','suspenso','encerrado','cancelado') NOT NULL DEFAULT 'ativo',
    `observacoes` TEXT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`cliente_id`) REFERENCES `t_clientes`(`id`),
    UNIQUE KEY `uk_contrato_numero` (`numero_contrato`)
);

CREATE TABLE `t_atendimentos`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `protocolo` VARCHAR(20) NOT NULL,
    `paciente_id` BIGINT UNSIGNED NOT NULL,
    `veiculo_id` BIGINT UNSIGNED NULL,
    `profissional_id` BIGINT UNSIGNED NULL,
    `contrato_id` BIGINT UNSIGNED NULL,
    `data_atendimento` DATETIME NOT NULL,
    `local` ENUM('residencia','hospital','via_publica','evento','outro') NOT NULL,
    `endereco` TEXT NULL,
    `queixa_principal` TEXT NOT NULL,
    `sinais_vitais` JSON NULL,
    `procedimento` TEXT NOT NULL,
    `destino` VARCHAR(255) NULL,
    `valor_servico` DECIMAL(10, 2) NULL,
    `status` ENUM('agendado','em_andamento','finalizado','cancelado') NOT NULL,
    `observacoes` TEXT NULL,
    `fatura_id` BIGINT UNSIGNED NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`paciente_id`) REFERENCES `t_clientes`(`id`),
    FOREIGN KEY (`veiculo_id`) REFERENCES `t_veiculos`(`id`),
    FOREIGN KEY (`profissional_id`) REFERENCES `t_profissionais`(`id`),
    FOREIGN KEY (`contrato_id`) REFERENCES `t_contratos`(`id`),
    UNIQUE KEY `uk_atendimento_protocolo` (`protocolo`)
);

-- MODULO FINANCEIRO

CREATE TABLE `t_faturas`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `numero_fatura` VARCHAR(20) NOT NULL,
    `cliente_id` BIGINT UNSIGNED NOT NULL,
    `atendimento_id` BIGINT UNSIGNED NULL,
    `data_servico` DATE NOT NULL,
    `data_emissao` DATE NOT NULL,
    `data_vencimento` DATE NULL,
    `data_pagamento` DATE NULL,
    `valor_total` DECIMAL(12, 2) NOT NULL,
    `forma_pagamento` ENUM('boleto','pix','cartao','transferencia','dinheiro') NULL,
    `nota_fiscal` VARCHAR(50) NULL,
    `status` ENUM('pendente','pago','cancelado','vencido') NOT NULL DEFAULT 'pendente',
    `observacoes` TEXT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`cliente_id`) REFERENCES `t_clientes`(`id`),
    FOREIGN KEY (`atendimento_id`) REFERENCES `t_atendimentos`(`id`),
    UNIQUE KEY `uk_fatura_numero` (`numero_fatura`)
);

CREATE TABLE `t_itens_fatura`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fatura_id` BIGINT UNSIGNED NOT NULL,
    `servico_id` BIGINT UNSIGNED NOT NULL,
    `quantidade` INT NOT NULL DEFAULT 1,
    `valor_unitario` DECIMAL(10, 2) NOT NULL,
    `descricao` TEXT NULL,
    FOREIGN KEY (`fatura_id`) REFERENCES `t_faturas`(`id`),
    FOREIGN KEY (`servico_id`) REFERENCES `t_servicos`(`id`)
);

CREATE TABLE `t_pagamentos_profissionais`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `profissional_id` BIGINT UNSIGNED NOT NULL,
    `atendimento_id` BIGINT UNSIGNED NULL,
    `data_servico` DATE NOT NULL,
    `valor_acordado` DECIMAL(10, 2) NOT NULL,
    `data_pagamento` DATE NULL,
    `forma_pagamento` ENUM('pix','transferencia','dinheiro') NOT NULL,
    `status` ENUM('pendente','pago','cancelado') NOT NULL DEFAULT 'pendente',
    `observacoes` TEXT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`profissional_id`) REFERENCES `t_profissionais`(`id`),
    FOREIGN KEY (`atendimento_id`) REFERENCES `t_atendimentos`(`id`)
);

-- MODULO DE ESTOQUE E AMBULÂNCIAS

CREATE TABLE `t_farmacia_estoque`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `codigo` VARCHAR(50) NOT NULL,
    `descricao` VARCHAR(255) NOT NULL,
    `lote` VARCHAR(50) NOT NULL,
    `tipo` ENUM('medicamento','material','equipamento') NOT NULL,
    `quantidade` INT NOT NULL DEFAULT 0,
    `unidade` ENUM('un','cx','fr','amp','outro') NOT NULL,
    `controle` ENUM('comum','controlado','psicotropico') NOT NULL,
    `validade` DATE NULL,
    `local_armazenamento` VARCHAR(100) NOT NULL,
    `estoque_minimo` INT NOT NULL DEFAULT 0,
    `ativo` BOOLEAN NOT NULL DEFAULT TRUE,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY `uk_estoque_codigo_lote` (`codigo`, `lote`)
);

CREATE TABLE `t_kits_ambulancia`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `veiculo_id` BIGINT UNSIGNED NOT NULL,
    `codigo` VARCHAR(50) NOT NULL,
    `nome` VARCHAR(100) NOT NULL,
    `tipo` ENUM('trauma','parto','medicamentos','oxigenio','outro') NOT NULL,
    `ultima_verificacao` DATE NULL,
    `proxima_verificacao` DATE NULL,
    `observacoes` TEXT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`veiculo_id`) REFERENCES `t_veiculos`(`id`),
    UNIQUE KEY `uk_kit_codigo` (`codigo`)
);

CREATE TABLE `t_kit_itens_ambulancia`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `kit_id` BIGINT UNSIGNED NOT NULL,
    `estoque_id` BIGINT UNSIGNED NOT NULL,
    `quantidade` INT NOT NULL DEFAULT 1,
    `validade` DATE NULL,
    `observacoes` TEXT NULL,
    FOREIGN KEY (`kit_id`) REFERENCES `t_kits_ambulancia`(`id`),
    FOREIGN KEY (`estoque_id`) REFERENCES `t_farmacia_estoque`(`id`)
);

CREATE TABLE `t_estoque_ambulancia`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `veiculo_id` BIGINT UNSIGNED NOT NULL,
    `item_id` BIGINT UNSIGNED NOT NULL,
    `quantidade_atual` INT NOT NULL DEFAULT 0,
    `quantidade_minima` INT NOT NULL DEFAULT 0,
    `ultima_reposicao` DATE NULL,
    `proxima_verificacao` DATE NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`veiculo_id`) REFERENCES `t_veiculos`(`id`),
    FOREIGN KEY (`item_id`) REFERENCES `t_farmacia_estoque`(`id`),
    UNIQUE KEY `uk_estoque_veiculo_item` (`veiculo_id`, `item_id`)
);

-- MODULO OPERACIONAL

CREATE TABLE `t_manutencoes_veiculos`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `veiculo_id` BIGINT UNSIGNED NOT NULL,
    `tipo` ENUM('preventiva','corretiva','pneus','lavagem','outra') NOT NULL,
    `descricao` TEXT NOT NULL,
    `data_servico` DATE NOT NULL,
    `quilometragem` BIGINT NOT NULL,
    `custo_total` DECIMAL(10, 2) NOT NULL,
    `status` ENUM('agendada','em_andamento','concluida','cancelada') NOT NULL,
    `observacoes` TEXT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`veiculo_id`) REFERENCES `t_veiculos`(`id`)
);

CREATE TABLE `t_manutencao_servicos`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `manutencao_id` BIGINT UNSIGNED NOT NULL,
    `descricao` VARCHAR(255) NOT NULL,
    `custo` DECIMAL(10, 2) NOT NULL,
    `observacoes` TEXT NULL,
    FOREIGN KEY (`manutencao_id`) REFERENCES `t_manutencoes_veiculos`(`id`)
);

CREATE TABLE `t_agenda`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `cliente_id` BIGINT UNSIGNED NOT NULL,
    `servico_id` BIGINT UNSIGNED NOT NULL,
    `data` DATE NOT NULL,
    `hora` TIME NOT NULL,
    `local_atendimento` VARCHAR(255) NOT NULL,
    `status` ENUM('agendado','confirmado','realizado','cancelado') NOT NULL DEFAULT 'agendado',
    `observacoes` TEXT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`cliente_id`) REFERENCES `t_clientes`(`id`),
    FOREIGN KEY (`servico_id`) REFERENCES `t_servicos`(`id`)
);


CREATE INDEX `idx_atendimentos_data` ON `t_atendimentos`(`data_atendimento`);
CREATE INDEX `idx_atendimentos_status` ON `t_atendimentos`(`status`);
CREATE INDEX `idx_atendimentos_paciente` ON `t_atendimentos`(`paciente_id`);

CREATE INDEX `idx_faturas_cliente` ON `t_faturas`(`cliente_id`);
CREATE INDEX `idx_faturas_status` ON `t_faturas`(`status`);
CREATE INDEX `idx_faturas_vencimento` ON `t_faturas`(`data_vencimento`);

CREATE INDEX `idx_estoque_validade` ON `t_farmacia_estoque`(`validade`);
CREATE INDEX `idx_estoque_tipo` ON `t_farmacia_estoque`(`tipo`);
CREATE INDEX `idx_estoque_controle` ON `t_farmacia_estoque`(`controle`);