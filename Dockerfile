FROM centos:7

WORKDIR /

#=========================
# Dependencies & JAR
#=========================
COPY target/lib /usr/share/learndocker/lib
COPY target/learn-docker-1.0-SNAPSHOT.jar /usr/share/learndocker/learn-docker-1.0-SNAPSHOT.jar

#==================
# Setup Java
#==================
RUN yum update -y
RUN yum install -y unzip xvfb wget java-1.8.0-openjdk-devel

#==================
# Setup Chrome
#==================
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
RUN yum -y install google-chrome-stable_current_x86_64.rpm

#=====================
# Setup Chromedriver
#=====================
RUN wget -N https://chromedriver.storage.googleapis.com/2.35/chromedriver_linux64.zip -P ~/
RUN unzip ~/chromedriver_linux64.zip -d ~/
RUN rm ~/chromedriver_linux64.zip
RUN mv -f ~/chromedriver /usr/share/learndocker/chromedriver

#==================
# Begin Selenium
#==================
CMD java -jar /usr/share/learndocker/learn-docker-1.0-SNAPSHOT.jar

#=============================================
# Debug dummy process to keep container open.
#=============================================
#ENTRYPOINT ["tail", "-f", "/dev/null"]


