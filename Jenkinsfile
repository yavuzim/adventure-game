pipeline {
    agent any

    environment {
        GIT_CREDENTIALS = 'e7b24fa9-75dc-4e83-99a8-1e14a4570359'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                    credentialsId: env.GIT_CREDENTIALS, 
                    url: 'https://github.com/yavuzim/adventure-game.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'  // Maven kullanarak projeyi inşa eder
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'  // Maven kullanarak testleri çalıştırır
            }
        }

        stage('Commit and Push') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.GIT_CREDENTIALS, passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
                        sh 'git config user.name "yavuzim"'
                        sh 'git config user.email "kyavuzimer@gmail.com"'
                        sh 'git add .'
                        sh 'git commit -m "Automated commit by Jenkins"'
                        sh 'git push https://$GIT_USERNAME:$GIT_PASSWORD@github.com/yavuzim/adventure-game.git HEAD:main'
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed!'
        }
    }
}
