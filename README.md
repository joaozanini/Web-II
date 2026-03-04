# 📌 Sistema de Controle de Manutenção de Equipamentos

## 👥 Integrantes

- Ana Beatriz Rosa Henrique 
- João Vitor Zanini Pedro
- Erick BertolottI Stella 
- Lucas Sarnacki Guiraud 

---

# 📖 Descrição

Sistema Web para **Controle de Manutenção de Equipamentos**, baseado em solicitações de serviço e controle de histórico de estados.

O sistema possui dois perfis de acesso:

- 👤 Cliente  
- 🛠 Funcionário  

---

# 🛠 Tecnologias Utilizadas

## Backend
- Java 17+
- Spring Boot
- Spring Data JPA
- REST API
- MySQL
- SHA-256 + SALT para criptografia de senhas
- JavaMailSender para envio de e-mail

## Frontend
- Angular 17 (Standalone)
- Bootstrap / Material
- HTML, CSS, JavaScript (DHTML)

---

# 🔐 Segurança

- Todas as senhas são armazenadas utilizando **Hash SHA-256 + SALT**
- A senha inicial do cliente:
  - É gerada automaticamente (4 números)
  - É enviada por e-mail no momento do cadastro
- Nenhuma senha é armazenada em texto puro no banco de dados

---

# 🗄 Banco de Dados

Banco relacional: **MySQL**

O banco está:
- Normalizado até 3FN
- Com dados iniciais para testes
- Com massa de dados relevante para validação dos requisitos

### Dados mínimos para testes:
- 2 funcionários
- 4 clientes
- 5 categorias
- 20 solicitações com estados variados

---

# ⚙️ Como Executar o Projeto

---

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/joaozanini/Web-II
```

---

## 2️⃣ Criar banco de dados MySQL

```sql
CREATE DATABASE sysmanutencao;
```

---

## 3️⃣ Configurar o Backend

O projeto utiliza variáveis de ambiente para proteger credenciais.

No `application.properties`:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.mail.host=${MAIL_HOST}
spring.mail.port=${MAIL_PORT}
spring.mail.username=${MAIL_USER}
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

## 4️⃣ Configurar Variáveis de Ambiente

### Windows (PowerShell)

```powershell
setx DB_URL "jdbc:mysql://localhost:3306/sysmanutencao?useSSL=false&serverTimezone=America/Sao_Paulo"
setx DB_USER "root"
setx DB_PASSWORD "sua_senha"

setx MAIL_USER "seu_email@gmail.com"
setx MAIL_PASSWORD "senha_de_app"
```

Reinicie a IDE após configurar.

---

# 📩 Configuração do E-mail (Gmail)

1. Ativar verificação em duas etapas na conta Google.
2. Gerar uma **Senha de App**.
3. Utilizar essa senha como `MAIL_PASSWORD`.

⚠ Não utilizar a senha normal da conta.

---

## 5️⃣ Executar o Backend

```bash
mvn spring-boot:run
```

Ou executar diretamente pela IDE.

---

## 6️⃣ Executar o Frontend (Angular)

```bash
cd frontend
npm install
ng serve
```

A aplicação estará disponível em:

```
http://localhost:4200
```

---

# 📌 Requisitos Funcionais Implementados

✔ RF001 – Autocadastro  
✔ RF002 – Login  
✔ RF003 – Página Inicial Cliente  
✔ RF004 – Solicitação de Manutenção  
✔ RF005 – Mostrar Orçamento  
✔ RF006 – Aprovar Serviço  
✔ RF011 – Página Inicial Funcionário  
✔ RF012 – Efetuar Orçamento  
✔ RF017 – CRUD Categoria  
✔ RF018 – CRUD Funcionário  

---

# 📊 Estados da Solicitação

- ABERTA  
- ORÇADA  
- REJEITADA  
- APROVADA  
- REDIRECIONADA  
- ARRUMADA  
- PAGA  
- FINALIZADA  

Cada alteração de estado é registrada com:
- Data/Hora
- Funcionário responsável

---

# 📄 Relatórios

- Relatório de Receita por Período (PDF)
- Relatório de Receita por Categoria (PDF)

---

# 📌 Observações Importantes

- Todas as datas utilizam formato brasileiro.
- Valores monetários seguem padrão brasileiro.
- Endereço do cliente é preenchido automaticamente via API ViaCEP.
- Remoções utilizam mecanismo de desativação (soft delete).
- O sistema deve ser testado no navegador Firefox (versão mais recente).
