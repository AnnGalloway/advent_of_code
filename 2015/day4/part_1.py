#with thanks to various users on reddit

import itertools
from hashlib import md5

def computeMG5hash(string):
    return md5(string.encode()).hexdigest()

secret = 'bgvyzdsv'

for n in range (1, 10000000):
    key = secret + str(n)
    h = computeMG5hash(key)
    if h[:6] == "000000":
        print(key,h)
        break