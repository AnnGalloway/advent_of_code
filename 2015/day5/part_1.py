vowels = ['a','e','i','o','u']
naughty_string = ['ab','cd','pq','xy']

input_string = open('input.txt').read()
if input_string[-1] == '\n':
    input_string = input_string[:-1]

def naughty_or_nice(word):
    vowel_count = 0
    prev_l = ''
    double_letter = False
    for l in word:
        if l in vowels:
            vowel_count += 1
        if prev_l != '' and l == prev_l:
            double_letter = True
        if prev_l != '' and prev_l + l in naughty_string:
            return False
        prev_l = l
    return vowel_count > 2 and double_letter == True

count = 0
for s in input_string.split('\n'):
    if naughty_or_nice(s):
        count += 1
print(count)