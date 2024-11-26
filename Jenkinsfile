pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'peterarsentev/job4j_devops'
        DOCKER_CREDENTIALS_ID = 'dockerhub-credentials' // Jenkins credentials for Docker Hub
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                checkout scm
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image using the Dockerfile in the repository
                    docker.build("${DOCKER_IMAGE}:${BUILD_NUMBER}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    // Push Docker image to Docker Hub
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        docker.image("${DOCKER_IMAGE}:${BUILD_NUMBER}").push()
                    }
                }
            }
        }
    }
    post {
        always {
            // Clean up any temporary files or images
            sh 'docker image prune -f'
        }
    }
}
