import numpy as np
import random
from matplotlib import pyplot as plt

# Experiment 1

ar_A = []
ar_B = []
ar_C = []
ar_X = []

av_A = []
av_B = []
av_C = []
av_X = []
vr_X = []

# Populate the given arrays.
### YOUR CODE HERE ###
for i in range(30000):
    a = random.random()
    if (a < 1 / 6):
       a = 1
    elif (a < 2 * (1 / 6)):
        a = 2
    elif (a < 3 * (1 / 6)):
        a = 3
    elif (a < 4 * (1 / 6)):
        a = 4
    elif (a < 5 * (1 / 6)):
        a = 5
    elif (a < 6 * (1 / 6)):
        a = 6
    ar_A.append(a)


    b = random.random()
    if (b < 1/4):
        b = 1
    elif(b < 2*(1/4)):
        b = 2
    elif(b < 3*(1/4)):
        b = 3
    elif(b < 4*(1/4)):
        b = 4
    ar_B.append(b)

    c = random.random()
    if(c < 1/2):
        c = -1
    else:
        c = 1
    ar_C.append(c)

    x = a + (b*c)
    ar_X.append(x)

totalA = 0
for j in range(len(ar_A)):
    totalA += ar_A[j]
    averageA = totalA / (j+1)
    av_A.append(averageA)

totalB = 0
for j in range(len(ar_B)):
    totalB += ar_B[j]
    averageB = totalB / (j+1)
    av_B.append(averageB)

totalC = 0
for j in range(len(ar_C)):
    totalC += ar_C[j]
    averageC = totalC / (j+1)
    av_C.append(averageC)

totalX = 0
for j in range(len(ar_X)):
    totalX += ar_X[j]
    averageX = totalX / (j+1)
    av_X.append(averageX)

totalvarX = 0
varianceX = 0
for j in range(len(ar_X)):
    if (j==0):
        varianceX = 0 #in the first trial, there is no variance yet
    else:
        totalvarX += (ar_X[j] - av_X[j])**2
        varianceX = totalvarX / j
    vr_X.append(varianceX)

# Inspect the following plots.
plt.figure()
plt.hist(ar_A,6,range=(1,7),align='left',density=True, rwidth=0.8)
plt.figure()
plt.hist(ar_B,4,range=(1,5),align='left',density=True, rwidth=0.8)
plt.figure()
plt.hist(ar_C,3,range=(-1,2),align='left',density=True, rwidth=0.8)
plt.figure()
plt.hist(ar_X,14,range=(-3,11),align='left',density=True, rwidth=0.8)

# Plot the average and variance values.
### YOUR CODE HERE ###
x_av_A = [x for x in range(len(av_A))]
y_av_A= av_A

x_av_B = [x for x in range(len(av_B))]
y_av_B= av_B

x_av_C = [x for x in range(len(av_C))]
y_av_C= av_C

x_av_X = [x for x in range(len(av_X))]
y_av_X= av_X

x_vr_X = [x for x in range(len(vr_X))]
y_vr_X= vr_X

plt.figure()
plt.plot(x_av_A,y_av_A)
plt.figure()
plt.plot(x_av_B,y_av_B)
plt.figure()
plt.plot(x_av_C,y_av_C)
plt.figure()
plt.plot(x_av_X,y_av_X)
plt.figure()
plt.plot(x_vr_X,y_vr_X)


# Experiment 2

# Part a (Inverse Transform Method)
U = []
Xa = []
av_Xa = []
vr_Xa = []

# Populate the given arrays.
### YOUR CODE HERE ###

for i in range(30000):
    u = random.random()
    x = u ** (1 / 2)
    U.append(u)
    Xa.append(x)

totalXa = 0
for j in range(len(Xa)):
    totalXa += Xa[j]
    averageXa = totalXa / (j+1)
    av_Xa.append(averageXa)

totalvarXa = 0
for j in range(len(Xa)):
    if (j==0):
        varianceXa = 0 #in the first trial, there is no variance yet
    else:
        totalvarXa += (Xa[j] - av_Xa[j])**2
        varianceXa = totalvarXa / j
    vr_Xa.append(varianceXa)

# Inspect the following plots.
plt.figure()
for i in range(len(Xa)):
    plt.plot([Xa[i],U[i]],[1,1.2])
plt.figure()
hU = plt.hist(U,100,alpha=0.5,density=True)
hXa = plt.hist(Xa,100,alpha=0.5,density=True)
plt.figure()
plt.plot(np.cumsum(hU[0]))
plt.plot(np.cumsum(hXa[0]))

# Plot the average and variance values.
### YOUR CODE HERE ###

x_av_Xa = [x for x in range(len(av_Xa))]
y_av_Xa= av_Xa

x_vr_Xa = [x for x in range(len(vr_Xa))]
y_vr_Xa= vr_Xa

plt.figure()
plt.plot(x_av_Xa,y_av_Xa)
plt.figure()
plt.plot(x_vr_Xa,y_vr_Xa)


# Part b (Rejection Method)
Xb = []
av_Xb = []
vr_Xb = []

# Populate the given arrays.
### YOUR CODE HERE ###

def f(x):
    return 2*x

a = 0
b = 1
c = f(b)

for i in range(30000):
    u = random.random()
    v = random.random()
    X = a + (b - a) * u
    Y = c * v
    while Y > f(X):
        u = random.random()
        v = random.random()
        X = a + (b - a) * u
        Y = c * v
    Xb.append(X)


totalXb = 0
for j in range(len(Xb)):
    totalXb += Xb[j]
    averageXb = totalXb / (j+1)
    av_Xb.append(averageXb)

totalvarXb = 0
for j in range(len(Xb)):
    if (j==0):
        varianceXb = 0 #in the first trial, there is no variance yet
    else:
        totalvarXb += (Xb[j] - av_Xb[j])**2
        varianceXb = totalvarXb / j
    vr_Xb.append(varianceXb)

# Inspect the following plots.
plt.figure()
hXb = plt.hist(Xb,100,density=True)
plt.figure()
plt.plot(np.cumsum(hXb[0]))

# Plot the average and variance values.
### YOUR CODE HERE ###

x_av_Xb = [x for x in range(len(av_Xb))]
y_av_Xb= av_Xb

x_vr_Xb = [x for x in range(len(vr_Xb))]
y_vr_Xb= vr_Xb

plt.figure()
plt.plot(x_av_Xb,y_av_Xb)
plt.figure()
plt.plot(x_vr_Xb,y_vr_Xb)

plt.show()
plt.close()