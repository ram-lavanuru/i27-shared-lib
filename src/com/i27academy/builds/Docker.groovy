package com.i27academy.builds

class Docker {
    def jenkins
    Docker(jenkins) {
        this.jenkins = jenkins
    }

    def build(appName) {
        jenkins.sh"""
        echo "*****builiding the $appName application"
        mvn clean package -DskipTests=true
        """
    }


    // def multiply (firstNumber, secondNumber) {
    // return firstNumber*secondNumber
    // }
}


// 
// def build() {
//     return {
//         echo "*****builiding the ${env.APPLICATION_NAME} application"
//         sh 'mvn clean package -DskipTests=true'
//     }
// }