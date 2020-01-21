FROM 192.168.69.130:20202/vmall/cse-huawei-jre:8u201

WORKDIR /home/apps/   
ENV JRE_HOME=$JAVA_HOME 
ENV CLASSPATH=.:${JRE_HOME}/lib \ 
    PATH=$JRE_HOME/bin:$PATH 
ADD ./target/activity_rules-1.0.0-SNAPSHOT.jar ./

ADD start.sh .

ENTRYPOINT ["sh", "/home/apps/start.sh"]
