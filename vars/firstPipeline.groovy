//import the calculator class from com.rr.builds
//pipeline+groovy
import com.rr.builds.Calculator

def call(Map pipelineparams){
    //an instance of the class called caluculator is created
Calculator calculator = new Calculator(this)

pipeline {
    agent any
    environment {
        APP_NAME = "${pipelineparams.appName}" //this value should be coming form mirco services
    }
    stages {
        stage ('addtionStage') {
            steps {
                script {
                    echo "printing sum of 2 numbers"
                    println calculator.add(3,4)
                    echo "micro service name is :${APP_NAME}"
                }
            }
        }
        stage ('secondStage') {
            steps {
                echo "printing second stage"
            }
        }
    }
}
}
