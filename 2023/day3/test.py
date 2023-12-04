input_string = open('input.txt').read()
use_string = input_string.split('\n')
new_string = []
for l in use_string:
    l = l.replace('*','.').replace('-','.').replace('#','.').replace('=','.').replace('+','.').replace('@','.').replace('$','.').replace('/','.').replace('%','.').replace('&','.')
    l = l.replace('.',' ').replace('   ',' ').replace('   ',' ').replace('   ',' ').replace('   ',' ').replace('  ',' ')
    l = l.split()
    for s in l:
        new_string.append(s)

string_len = []
for l in new_string:
    string_len.append(len(l))
print(string_len)
print(max(string_len))