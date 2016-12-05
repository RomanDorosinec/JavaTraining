title TestsWebDriver
cd vagrant-lamp-wordpress
vagrant up
vagrant ssh 'sudo mysql -u root -proot wordpress < /vagrant/wordpressBD.sql; /bin/bash/'--wait-exit
cd ..
start report.cmd