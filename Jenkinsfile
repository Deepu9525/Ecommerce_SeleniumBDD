pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven310'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building Ecommerce project'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Executing Selenium tests'
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
        success {
            echo 'Build and Test successful'
        }
        failure {
            echo 'Build or Test failed'
        }
    }
}