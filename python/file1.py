def getSums(fp):
    with open(fp) as fh:
        lines = fh.readlines()
        n_val = []
        for i in lines:
            l_clean = i.replace('\n', '')
            n_val.append(int(l_clean))
        fh.close()
        return n_val


v = getSums('f1_v.txt')

with open('f1.txt') as f:
    lines = f.readlines()  # list of strings with a \n
    l = 0
    for i in lines:
        l_clean = i.replace('\n', '')
        l_split = l_clean.split(',')
        print(l_split)
        s = 0
        for j in l_split:
            s += int(j)
        print(f'Soma linha {s} == validacao? {v[l]}', s == v[l])
        l += 1
    f.close()

with open('f1.txt') as f:
    lines = f.readline()  # le so uma linha read() le todo conteúdo
    f.close()

print(getSums('f1_v.txt'))
