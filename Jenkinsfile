pipeline {
    agent { label 'agent1' }

    stages {
        stage('Checkstyle main') {
            steps {
                echo './gradlew checkstyleMain'
            }
        }
        stage('Checkstyle test') {
            steps {
                echo './gradlew checkstyleTest'
            }
        }
        stage('Compile') {
            steps {
                echo './gradlew checkstyleMain'
            }
        }
        stage('Test') {
            steps {
                echo './gradlew checkstyleTest'
            }
        }
        stage('JaCoCo Report') {
            steps {
                echo './gradlew jacocoTestReport'
            }
        }
        stage('JaCoCo Verification') {
            steps {
                echo './gradlew jacocoTestCoverageVerification'
            }
        }
    }
}