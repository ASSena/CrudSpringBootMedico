ALTER TABLE medicos ADD COLUMN IF NOT EXISTS ativo TINYINT;
update medicos set ativo = 1;