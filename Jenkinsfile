pipeline {
    agent { label 'built-in' }

    stages {
        stage('SCM Checkout') {
            steps {
                echo 'Source code checked out from GitHub'
            }
        }

        stage('Check Java and Maven') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Verify and Archive JAR') {
            steps {
                sh 'ls -lh target/*.jar'

                archiveArtifacts(
                    artifacts: 'target/*.jar',
                    fingerprint: true
                )
            }
        }
    }

    post {
        success {
            echo 'BUILD SUCCESSFUL! JAR ARCHIVED!'
        }

        failure {
            echo 'BUILD FAILED. Check the console output.'
        }
    }
}
