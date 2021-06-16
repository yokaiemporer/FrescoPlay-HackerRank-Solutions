import os, re, os.path
import shutil
mypath = "."
for root, dirs, files in os.walk(mypath):
    for file in files:
        if file==".git":
            shutil.rmtree(os.path.join(root,".git"))
        
        # os.remove()