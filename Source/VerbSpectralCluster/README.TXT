In the name of Allah

--------------------------------
VerbSpectralCluster version 1.0
      10 January 2013
--------------------------------

This is the README for the "VerbSpectralCluster" package that is used for adding 
verb spectral cluster id to dependency parsing. This package has been developed 
by Mojtaba Khallash (mkhallash@gmail.com) from Iran University of Science and 
Technology (IUST).

The home page for the project is:
	http://nlp.iust.ac.ir

The code is available on Github at:
	https://github.com/mojtaba-khallash/verb-spectral-cluster
	
If you want to use this software for research, please refer to this web address 
in your papers.

-------------------------

The package can be used freely for non-commercial research and educational 
purposes. It comes with no warranty, but we welcome all comments, bug reports, 
and suggestions for improvements.

------------------
Table of contents
------------------

1. Compiling

2. Example of usage

3. Running the package

4. References

----------------
1. Compiling
----------------

Requirements:
* Version 1.7 or later of the Java 2 SDK (http://java.sun.com)
  You must add java binary file to system path. In linux, your
  can open ~/.bashrc file and append this line:
    PATH=$PATH:/<address-of-bin-folder-of-JRE>

To compile the code, first decompress the package:

in linux:
$ tar -xvzf VerbSpectralCluster.tgz
$ cd VerbSpectralCluster
$ sh compile.sh

in windows:
- decompress the VerbSpectralCluster.zip
- compile.bat

You can open the all projects in NetBeans 7.1 (or maybe later) too
in both platforms.

---------------------
2. Example of Usage
---------------------

Goal of this package is adding id of semantic cluster to all verbs of 
dependency treebank. We use results of semantic classification of verbs in 
Persian language based on Levin’s idea [1].

-------------------------
3. Running the package
-------------------------

This package run in two mode: 

* gui [Default mode]
Simply double click on jar file or run the following command:

> java -jar VerbSpectralCluster.jar

* command-line
In order to running package in command-line mode must be set -v flag (visible) 
to 0:

> java -jar VerbSpectralCluster.jar -v 0 -i <input-file> -o <output-file>

-i <Input CoNLL file>
	intput CoNLL file that you want to add semantic verb cluster IDs to
	it `FEATS` column.
	
-o <Output CoNLL file>
	name of output CoNLL file.

For example:

> java -jar VerbSpectralCluster.jar -v 0 -i input.conll -o output.conll

------------
References
------------
[1]	M. Aminian, "Semantic Clustering of Persian Verbs", M. Sc. Thesis, 
	Sharif University of Technology, Tehran, 2012.