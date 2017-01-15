mvn clean test site
cd vagrant-lamp-wordpress
vagrant ssh -c 'sudo sh /vagrant/importTable.sh /bin/bash'--wait-exit
#vagrant halt