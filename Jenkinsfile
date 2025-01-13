pipeline {
    agent { label 'agent-jdk21' }

    tools {
        git 'Default'
    }

    stages {
        stage('Prepare Environment') {
            steps {
                script {
                    sh 'chmod +x ./gradlew'
                }
            }
        }
        stage('Update DB') {
                            steps {
                                script {
                                    sh './gradlew update -P"dotenv.filename"="/var/agent-jdk21/env/.env.develop"'
                                }
                            }
         }
        stage('check') {
            steps {
                script {
                    sh './gradlew check -P"dotenv.filename"="/var/agent-jdk21/env/.env.develop"'
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    sh './gradlew build'
                }
            }
        }
        stage('JaCoCo Report') {
            steps {
                script {
                    sh './gradlew jacocoTestReport'
                }
            }
        }
        stage('JaCoCo Verification') {
            steps {
                script {
                    sh './gradlew jacocoTestCoverageVerification'
                }
            }
        }

        stage('Docker build') {
            steps {
                sh 'docker build -t job4j_devops .'
            }
        }
    }

    post {
        always {
                script {
                    def buildInfo = "Build number: ${currentBuild.number}\n" +
                                    "Build status: ${currentBuild.currentResult}\n" +
                                    "Started at: ${new Date(currentBuild.startTimeInMillis)}\n" +
                                    "Duration so far: ${currentBuild.durationString}"
                    telegramSend(message: buildInfo)
                }
        }
    }
}
