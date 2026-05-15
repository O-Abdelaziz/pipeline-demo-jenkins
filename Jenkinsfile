pipeline {
  agent any
  environment {
    IMAGE = "ci-cd-flask:latest"
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        sh 'python3 -m venv .venv || true'
        sh '. .venv/bin/activate && pip install -r requirements.txt'
      }
    }
    stage('Test') {
      steps {
        sh '. .venv/bin/activate && pytest -q'
      }
    }
    stage('Docker Build') {
      steps {
        sh 'docker build -t $IMAGE .'
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker compose up -d --build'
      }
    }
  }
  post {
    always {
      echo 'Pipeline finished.'
    }
  }
}
