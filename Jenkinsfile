pipeline {
agent any

stages{
stage("Preparation") {
   steps {
   echo 'Download updates'
   git 'https://github.com/svitlana12151/aqa_java_tasks.git'
    }
   }
   stage("Unit Test") {
      steps {
      bat 'mvn clean -DsuiteXmlFile=testng.xml test'
       }
      }
 stage("UI test") {
    steps {
    bat 'mvn clean -DsuiteXmlFile=allure-testng.xml'
     }
    }
    stage('reports'){
    }
    }
    post{
    always {
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
