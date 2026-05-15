# CI/CD Pipeline Demo (Flask)

This repository contains a minimal Python Flask app and a Jenkins pipeline (Jenkinsfile) demonstrating a full CI/CD cycle: checkout, build, test, and deploy.

What's included
- `app/` – Flask application and templates
- `tests/` – pytest tests
- `Dockerfile` – builds the app image
- `docker-compose.yml` – deploys the app locally
- `Jenkinsfile` – declarative pipeline covering checkout, build, test, docker build, deploy

Quick local run
1. Create venv and install:
```bash
python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
flask --app app.app run
```

2. Open http://localhost:5000

Run tests
```bash
source .venv/bin/activate
pytest -q
```

Run with Docker Compose
```bash
docker compose up --build -d
docker compose logs -f
```

Jenkins
- Create a pipeline job pointing to this repository. Ensure the Jenkins agent has Docker installed and can run `docker` and `docker compose`.
- The `Jenkinsfile` runs the same steps: setup, install, pytest, docker build, and `docker compose up -d` for deploy.

Screenshots
- Pipeline success: open the Jenkins job run page and capture the pipeline success view.
- Application UI: after deploy, open `http://<agent-ip>:8000` (or `localhost:8000` if running locally) and capture the UI.

Push to GitHub
1. `git init` (if needed)
2. `git add .` && `git commit -m "Add CI/CD demo scaffold"`
3. Create repo on GitHub and push:
```bash
git remote add origin <your-repo-url>
git push -u origin main
```
