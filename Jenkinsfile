pipeline {
    agent any

    triggers {
    cron('* 1 * * *')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }


    parameters {
         choice(choices: ['Chrome', 'Edge', 'Yandex'], description: 'Select a browser', name: 'BROWSER')
         choice(choices: ['SmokeTest.xml', 'NegativeTest.xml'], description: 'Running tests', name: 'SUITE_NAME')


         gitParameter( branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH')
  }


  stages {
        stage('Run tests') {
            steps {

                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/SergeiGlinisty/Salesforce_SergeyGlinisty.git'

                // Run Maven on a Unix agent.
               bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlFile=${params.SUITE_NAME} -Dbrowser=${params.BROWSER} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }

    }
}