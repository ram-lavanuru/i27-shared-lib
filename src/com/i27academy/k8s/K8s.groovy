package com.i27academy.k8s
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
        gcloud compute instances list
        echo "********get nodes*****"
        gcloud --version
        gcloud container clusters get-credentials i27-cluster --zone us-central1-a --project devops-project-448505
        kubectl get nodes
        """
    }

    def k8sDeploy() {
        jenkins.sh"""
        echo "***deploying to dev through k8s***"
        echo "list the files"
        sh "ls -la"      
        """
    }
}