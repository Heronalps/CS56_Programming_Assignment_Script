#! /bin/bash
./test.sh assign2 HotWordsAnalyzer > log.txt
more log.txt | grep -A 2 Failure | grep tar > NotPassTheTest.txt
more log.txt | grep -A 2 OK | grep tar > PassTheTest.txt
more NotPassTheTest.txt
