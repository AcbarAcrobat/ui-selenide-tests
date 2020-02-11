# ui-selenide-tests
Sample test for Evotor

If you installed JDK + Gradle:
Go to /path/to/ui-selenide-test
$gradle init
press enter 3 more
When projetct is initialized:
$gradle build

1. Install OpenJDK
Gradle requires Java JDK or JRE version 7 or above to be installed. We’ll install OpenJDK 8.

The installation of Java is pretty simple. Start by updating the package index:

sudo apt update
Install the OpenJDK package by typing:

sudo apt install openjdk-8-jdk
Verify the Java installation by running the following command which will print the Java version:

java -version
The output should look something like this:

openjdk version "1.8.0_181"
OpenJDK Runtime Environment (build 1.8.0_181-8u181-b13-0ubuntu0.18.04.1-b13)
OpenJDK 64-Bit Server VM (build 25.181-b13, mixed mode)
2. Download Gradle
At the time of writing this article, the latest version of Gradle is 5.0. Before continuing with the next step you should check the Gradle releases page to see if a newer version is available.

Start by downloading the Gradle Binary-only zip file in the /tmp directory using the following wget command:

wget https://services.gradle.org/distributions/gradle-5.0-bin.zip -P /tmp
Once the download is completed, extract the zip file in the /opt/gradle directory:
sudo unzip -d /opt/gradle /tmp/gradle-*.zip
Verify that the Gradle files are extracted by listing the /opt/gradle/gradle-5.0 directory:

ls /opt/gradle/gradle-5.0
bin  getting-started.html  init.d  lib  LICENSE  media  NOTICE
3. Setup environment variables
Next, we’ll need to configure the PATH environment variable to include the Gradle bin directory. To do so, open your text editor and create a new file named gradle.sh inside of the /etc/profile.d/ directory.

sudo nano /etc/profile.d/gradle.sh
Paste the following configuration:

/etc/profile.d/gradle.sh
export GRADLE_HOME=/opt/gradle/gradle-5.0
export PATH=${GRADLE_HOME}/bin:${PATH}
Copy
Save and close the file. This script will be sourced at shell startup.
Make the script executable by issuing the following chmod command:

sudo chmod +x /etc/profile.d/gradle.sh
Load the environment variables using the source command:

source /etc/profile.d/gradle.sh
4. Verify the Gradle installation
To validate that Gradle is installed properly use the gradle -v command which will display the Gradle version:
gradle -v
You should see something like the following:

Welcome to Gradle 5.0!

Here are the highlights of this release:
 - Kotlin DSL 1.0
 - Task timeouts
 - Dependency alignment aka BOM support
 - Interactive `gradle init`

For more details see https://docs.gradle.org/5.0/release-notes.html


------------------------------------------------------------
Gradle 5.0
------------------------------------------------------------

Build time:   2018-11-26 11:48:43 UTC
Revision:     7fc6e5abf2fc5fe0824aec8a0f5462664dbcd987

Kotlin DSL:   1.0.4
Kotlin:       1.3.10
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          1.8.0_181 (Oracle Corporation 25.181-b13)
OS:           Linux 4.15.0-36-generic amd64
