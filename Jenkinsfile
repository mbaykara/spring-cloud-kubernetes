/* Hello World in Groovy */
pipeline {
    agent {
        label 'prod'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('CR_REGISTRY')
    }
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code repository
                git branch: 'main', url: 'https://github.com/mbaykara/spring-cloud-kubernetes.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                withCredentials([usernamePassword(credentialsId: 'CR_REGISTRY', usernameVariable: 'CR_USERNAME', passwordVariable: 'CR_PASSWORD')]) {
                        // Your Docker build and push steps here
                    sh 'mvn compile jib:build -Djib.to.tags=k8s' 
                }
            }
            post {
                success {
                    // Actions to perform after a successful build
                    echo 'Maven build successful!'
                    // You can add additional steps like archiving artifacts, publishing reports, etc.
                }
                failure {
                    // Actions to perform if the build fails
                    echo 'Maven build failed!'
                    // You can add notifications or any cleanup steps here
                }
            }
        }
        stage('Deploy to Test Env') {
            agent {
                label 'test'
             }
            steps {
                echo "Deployment to Test env"
                sh 'docker kill test-nginx'
                sh 'docker run --rm -d --name test-nginx nginx'

            }
        }
        stage('Manual Approve to Production') {
            // input {
            //     message 'Do you want to deploy to prod environment?'
            //     id 'envId'
            //     ok 'Submit'
            //     submitterParameter 'approverId'
            //     parameters {
            //         choice choices: ['Yes'], name: 'envType'
            //     }
            // }

            steps {
                 //for multi branch pipelin
                script {
                    if (env.BRANCH_NAME == 'main') {
                        echo "Deployment approved to Prod"
                        sh 'docker run -d --name prod-nginx nginx'
                    }
                    else {
                        echo 'Pass Production  deployment'
                    }

                }
            }
        }
    }

    // You can add more stages for testing, deployment, etc.

    // Optional: Define post-build actions, notifications, etc.
    post {
        always {
            // Cleanup steps that should always run
            echo 'Build finished, performing cleanup...'

            // You can add post-build actions here
        }
    }
}
