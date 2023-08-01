import unicodedata
s = input('string a comparar: ')
s = s.lower()  # passa para minusculo (retorna string)
r_s = ''.join(reversed(s))
print('antes: ', s)
print(r_s)

# remover espaços
s_n = ''.join(ch for ch in unicodedata.normalize('NFKD', s)
              if not unicodedata.combining(ch))
r_s = ''.join(reversed(s_n))

print(s_n)

if (s_n == r_s):
    print('S')
else:
    print('N')
# for i in reversed(s):
#    print(i)

r = ''
# print(len(s))

for i in range(len(s)):
    # print(len(s)-i-1)
    r += s_n[len(s)-i-1]
    # r.append(s[len(s)-i-1]) #gera vetor de caracteres se r = []

if (s_n == r):
    print('S')
else:
    print('N')

# testar se algo está na string in
