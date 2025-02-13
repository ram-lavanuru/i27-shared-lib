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
        gcloud compute ssh --zone "us-central1-a" "gke-i27-cluster-default-pool-54ea84ef-d4dl" --project "devops-project-448505"
        kubectl get nodes
        """
    }
}