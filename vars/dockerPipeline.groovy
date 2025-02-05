import com.i27academy.builds.Calculator

def call(Map pipelineparams) {
    Calculator calculator = new Calculator(this)

    pipeline {
        agent {
            label 'k8s-slave'
        }
        environment {
            APPLICATION_NAME = "${pipelineparams.appName}"
        }
        stages {
            stage('addition') {
                steps {
                    script {
                        echo "printing of sum of 2 numbers"
                        println calculator.add(3,4)
                        echo "microservice name is ${APPLICATION_NAME}"
                    }
                }
            }
        }
    }
}
