package com.i27academy.K8s

class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jenkins
    }



    // def build(appName) {
    //     jenkins.sh"""
    //     echo "*****builiding the $appName application"
    //     mvn clean package -DskipTests=true
    //     """
    // }

    def auth_login() {
        jenkins.sh"""
        echo "********entering into k8s authentication/login method*****"
        gcloud compute insatnces list
        """
    }

}