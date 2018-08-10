#!/bin/bash

#
# Run the testsuite for the passed tag. Valid tags are ete, health, closedloop, instantiate
# Please clean up logs when you are done...
# Note: Do not run multiple concurrent ete.sh as the --display is not parameterized and tests will collide
#
if [ "$1" == "" ];then
   echo "Usage: ete.sh [ health | ete | closedloop | instantiate | distribute ]"
   exit
fi


DIRECTORY=$(cd `dirname $0` && pwd)
export TAGS="-i $1"
export ETEHOME=$DIRECTORY/OpenECOMP_ETE
export ETESHARE=$DIRECTORY/eteshare
mkdir -p $ETESHARE/logs
export GLOBAL_BUILD_NUMBER=$(ls -1q $ETESHARE/logs/ | wc -l)
export OUTPUT_FOLDER=ETE_$(printf %04d $GLOBAL_BUILD_NUMBER)_$1


VARIABLEFILES="-V $ETESHARE/config/vm_properties.py -V $ETESHARE/config/integration_robot_properties.py -V $ETESHARE/config/integration_preload_parameters.py"
VARIABLES="-v GLOBAL_BUILD_NUMBER:$GLOBAL_BUILD_NUMBER"

source ${ETEHOME}/runTags.sh ${VARIABLEFILES} ${VARIABLES} -d ./${OUTPUT_FOLDER} ${TAGS} --exclude oom --display 88
