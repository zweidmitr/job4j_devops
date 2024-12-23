pipeline {
    agent { label 'agent1' }

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
        stage('Checkstyle Main') {
            steps {
                script {
                    sh './gradlew checkstyleMain'
                }
            }
        }
        stage('Checkstyle Test') {
            steps {
                script {
                    sh './gradlew checkstyleTest'
                }
            }
        }
        stage('Compile') {
            steps {
                script {
                    sh './gradlew compileJava'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh './gradlew test'
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
                script {
                    sh """
                      docker build \
                        --build-arg GRADLE_REMOTE_CACHE_URL=${GRADLE_REMOTE_CACHE_URL} \
                        --build-arg GRADLE_REMOTE_CACHE_PUSH=${GRADLE_REMOTE_CACHE_PUSH} \
                        --build-arg GRADLE_REMOTE_CACHE_USERNAME=${GRADLE_REMOTE_CACHE_USERNAME} \
                        --build-arg GRADLE_REMOTE_CACHE_PASSWORD=${GRADLE_REMOTE_CACHE_PASSWORD} \
                        -t job4j_devops .
                    """
                }
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
