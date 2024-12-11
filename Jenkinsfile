pipeline {
    agent { label 'agent1' }

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
    }

    post {
        always {
            def buildInfo = """
                        Build number: ${currentBuild.number}\r\n
                        Build status: ${currentBuild.currentResult}\r\n
                        Started at: ${new Date(currentBuild.startTimeInMillis)}\r\n
                        Duration so far: ${currentBuild.durationString}\r\n
                    """.stripIndent()

            telegramSend(message: buildInfo)
        }
    }
}
