﻿:: Move to directory with vagrant

cd vagrant-lamp-wordpress

echo "-------------Start VM.-------------"

::vagrant up

echo "-------------VM is up!-------------"

vagrant ssh -c 'sudo sh /vagrant/importTable.sh /bin/bash'--wait-exit

echo "-------------Import DB complite!-------------"

cd ..

echo "-------------Executing tests!-------------"

startTests

cd vagrant-lamp-wordpress

echo "-------------Import DB complite!-------------"

vagrant ssh -c 'sudo sh /vagrant/importTable.sh /bin/bash'--wait-exit

::vagrant halt

PAUSE