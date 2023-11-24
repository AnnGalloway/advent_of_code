input_string = open('input.txt').read()
if input_string[-1] == '\n':
    input_string = input_string[:-1]

testing1 = 'aaaa'
testing2 = 'qjhvhtzxzqqjkmpb'
testing3 = 'xxyxx'
testing4 = 'uurcxstgmygtbstg'
testing5 = 'ieodomkazucvgmuy'
testing6 = 'testingagte'

def pair(word):
    i = 0
    pair = False
    while i < len(word)-3:
        j = i + 2
        while j < len(word)-1:
            #print(f'{word[i:i+1]}, {word[j:j+1]}')
            if word[i:i+2] == word[j:j+2]:
                pair = True
            j+=1
        i += 1
    return pair

def double_between(word):
    i = 0
    double = False
    while i < len(word)-2:
        if word[i] == word[i+2]:
            double = True
        i+= 1
    return double


'''print(double_between(testing1) and pair(testing1))
print(double_between(testing2) and pair(testing2))
print(double_between(testing3) and pair(testing3))
print(double_between(testing4) and pair(testing4))
print(double_between(testing5) and pair(testing5))
print(double_between(testing6) and pair(testing6))'''

count = 0
i = 1
for s in input_string.split('\n'):
    #print(f'{i} {double_between(s)}, {pair(s)}, {double_between(s) and pair(s)}')
    if double_between(s) and pair(s):
        count += 1
    i+=1
print(count)