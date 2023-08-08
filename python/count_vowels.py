# by Josenalde Oliveira
import unicodedata
s = input('string a comparar: ')
s = s.lower()  # passa para minusculo (retorna string)


s = ''.join(ch for ch in unicodedata.normalize('NFKD', s)
            if not unicodedata.combining(ch))

v = ['a', 'e', 'i', 'o', 'u']
c_v = 0
for l in v:
    c_v += s.count(l)


print(s + ' with: ' + str(c_v) + ' vowels')
