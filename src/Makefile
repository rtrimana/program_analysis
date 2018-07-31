
all: compile transformjimple

PHONY += compile
compile:
	javac -cp .:./path/to/soot-2.5.0.jar *.java
	cd Tests; javac -cp .:./../path/to/soot-2.5.0.jar *.java

PHONY += transformjimple
transformjimple:
	
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests -f J Test1_ReturnStatement
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests -f J Test2_FieldReference
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests -f J Test3_ArrayReference
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests -f J Test4_GlobalAssignment
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests -f J Test5_ConditionalStatement
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests -f J Test6_MethodCall
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests -f J Test7_MiscBranches
	cd Tests; cp GlobalVariable.class ../sootOutput

PHONY += transformclass
transformclass:

	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests Test1_ReturnStatement
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests Test2_FieldReference
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests Test3_ArrayReference
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests Test4_GlobalAssignment
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests Test5_ConditionalStatement
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests Test6_MethodCall
	java -cp .:./path/to/soot-2.5.0.jar Adapter -cp .:./path/to/rt.jar:./Tests Test7_MiscBranches
	cd Tests; cp GlobalVariable.class ../sootOutput
	
PHONY += plainsoot
plainsoot:
	
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests -f J Test1_ReturnStatement
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests -f J Test2_FieldReference
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests -f J Test3_ArrayReference
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests -f J Test4_GlobalAssignment
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests -f J Test5_ConditionalStatement
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests -f J Test6_MethodCall
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests -f J Test7_MiscBranches
	cd Tests; cp GlobalVariable.class ../sootOutput

PHONY += generateclass
generateclass:

	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests Test1_ReturnStatement
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests Test2_FieldReference
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests Test3_ArrayReference
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests Test4_GlobalAssignment
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests Test5_ConditionalStatement
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests Test6_MethodCall
	java -cp .:./path/to/soot-2.5.0.jar soot.Main -cp .:./path/to/rt.jar:./Tests Test7_MiscBranches
	cd Tests; cp GlobalVariable.class ../sootOutput
	
PHONY += clean
clean:
	rm -rf *.class
	cd Tests; rm -rf *.class
	rm -rf sootOutput

.PHONY: $(PHONY)
