pipeline {
    agent any
    //Browser selection using Jenkins Pipeline parameters
    parameters{
        choice(
                name: 'BROWSER',
                choices: ['chrome', 'edge', 'firefox'],
                description: 'Select browser for execution'
        )
    }

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
                //bat 'mvn test'
                //junit 'target/surefire-reports/*.xml'
                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    bat "mvn test -Dbrowser=${params.BROWSER}"
                }

                junit testResults: 'target/surefire-reports/*.xml',
                        allowEmptyResults: true
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