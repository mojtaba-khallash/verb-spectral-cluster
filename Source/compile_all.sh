#!/bin/bash
#alias java=/usr/lib/jvm/jdk1.7.0/bin/java
#alias javac=/usr/lib/jvm/jdk1.7.0/bin/javac
#alias jar=/usr/lib/jvm/jdk1.7.0/bin/jar

build_module() {
  echo "test $SRC_FILES"
  echo "compiling $MODULE .."
  cd $MODULE/src
  rm -R ../dist
  mkdir ../dist
  rm -R ../build
  mkdir ../build
  mkdir ../build/classes
  javac -classpath ".:../lib/*" -d ../build/classes $SRC_FILES
  cp ../../$MANIFEST ../build/classes/manifest.mf
  cd ../build/classes
  jar -cvfm ../../dist/${MODULE}.jar manifest.mf $CLASS_FILES
  cd ../../src
  jar -uvfm ../dist/${MODULE}.jar ../build/classes/manifest.mf $OTHER_FILES
  cd ..
  cp -r lib dist/
  cd ..
}

MANIFEST=manifest.mf
MODULE="VerbSpectralCluster"
SRC_FILES="./ir/ac/iust/nlp/verbspectralcluster/*.java"
CLASS_FILES="*.class ./ir/ac/iust/nlp/verbspectralcluster/*.class"
OTHER_FILES="*.txt ./ir/ac/iust/nlp/verbspectralcluster/*.form"
build_module

cd VerbSpectralCluster
cp -r appdata dist/
cp -r Treebank dist/
cp -r LICENSE.TXT dist/
cp -r README.TXT dist/