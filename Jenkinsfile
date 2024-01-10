/* Hello World in Groovy */
pipeline {
    agent {
        label 'prod'
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
                sh 'mvn compile jib:build -Djib.to.tags=k8s' // Or any other Maven commands you need
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

                script {
                    if (env.BRANCH_NAME == 'main' && userInput == true ) {
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

def userInput
try {
    userInput = input(
        id: 'Proceed1', message: 'Was this successful?', parameters: [
        [$class: 'BooleanParameterDefinition', defaultValue: true, description: '', name: 'Please confirm you agree with this']
        ])
} catch(err) { // input false
    def user = err.getCauses()[0].getUser()
    userInput = false
    echo "Aborted by: [${user}]"
}

  
