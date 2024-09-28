# %% Imports
import random
import numpy as np
import pylab as pl
from matplotlib import pyplot as plt


# %% Functions

# Function to generate a population with given parameter and size using the
# inverse transformation method.
def gen_inverse(k, M):
    # k is the parameter in the cdf
    # M is the size
    # X is the array that holds random variables that we generated
    X = []
    for i in range(M):
        u = random.random()
        x = u ** (1/(k+1))
        X.append(x)
    return X


# Function to generate a population with given parameter and size using the
# rejection method.
def gen_rejection(k, M):
    # k is the parameter in the pdf
    # M is the size
    # X is the array that holds random x variables that we generated
    # y is the random y variable that we generated
    X = []
    def f(x):
        return (k+1) * (x**k)

    # our x is in the range [0,1]
    a = 0
    b = 1
    c = f(b)

    for i in range(M):
        u = random.random()
        v = random.random()
        x = a + (b - a) * u
        y = c * v
        while y > f(x):
            u = random.random()
            v = random.random()
            x = a + (b - a) * u
            y = c * v
        X.append(x)
    return X



# Function to calculate the population mean using k.
def calc_population_mean(k):
    def E(x):
        return ((k+1) * (x**(k+2))) / (k+2)
    # our interval is [0,1]
    a = 0
    b = 1
    mean = E(b) - E(a)
    return mean



# Function to calculate the population variance using k.
def calc_population_variance(k):
    def E(x_squared):
        return ((k+1) * (x_squared**(k+3))) / (k+3)
    # our interval is [0,1]
    a = 0
    b = 1
    Ex2 = E(b) - E(a)
    variance = Ex2 - (calc_population_mean(k)**2)
    return variance


# Function to randomly take samples of size N from a population.
def random_sample(population, N):
    # sample is an array to hold our chosen variables
    sample = []
    for i in range(N):
        u = random.random()
        x = int(u * len(population))
        sample.append(population[x])
    return sample


# Function to calculate the sample mean.
def calc_sample_mean(sample):
    total = np.sum(sample)
    average = total / len(sample)
    return average

# Function to calculate the sample variance (biased/unbiased).
def calc_sample_variance(sample, unbiased=True):
    total_squared = 0
    mean = calc_sample_mean(sample)
    for i in sample:
        total_squared += (i - mean) ** 2
    n = len(sample)
    if unbiased:
        variance = total_squared / (n - 1)
    if not unbiased:
        variance = total_squared / n
    return variance

# Function to estimate the parameter k using method of moments
def estimate_k_mom(sample):
    # sample mean = population mean is the first moment
    # if we calculate this equation with a = 0 and b = 1
    # we get ((k+2)/(k+1))*(1**(k+2)) = sample_mean
    # we can omit the power of 1 because all powers of 1 is equal to 1
    # then when we make the necessary calculations
    # we get k = (2*sample_mean-1)/(1-sample_mean)
    # you can find calculations on my report
    sample_mean = calc_sample_mean(sample)
    k = (2 * sample_mean - 1) / (1 - sample_mean)
    return k

# Function to estimate the parameter k using maximum likelihood
def estimate_k_mle(sample):
    # we need to make the cdf maximum
    # we will calculate the multiplication of pdf of sample for all sample elements
    # we will take its partial derivative with respect to k
    # then we will say that this equation is equal to zero
    # after the necessary calculations we found k = (-M/sum(lnx))-1
    # you can find calculations on my report
    M = len(sample)
    log_of_sample = np.log(sample)
    total_log = np.sum(log_of_sample)
    k = (-M / total_log) - 1
    return k


# Function to calculate the confidence interval for population mean given the
# sample and the required confidence level. If population standard deviation is
# not provided, use sample standard deviation as its estimator. As confidence
# level, it should only accept 95, 96, 97, 98 and 99 for which the z values are
# hard-coded in the function.
def calc_conf_int_mean(sample, confidence_lvl, pop_std=0):
    z95 = 1.96
    z96 = 2.055
    z97 = 2.17
    z98 = 2.33
    z99 = 2.575

    if confidence_lvl == 95:
        z = z95
    elif confidence_lvl == 96:
        z = z96
    elif confidence_lvl == 97:
        z = z97
    elif confidence_lvl == 98:
        z = z98
    elif confidence_lvl == 99:
        z = z99

    if pop_std == 0:
        sample_variance = calc_sample_variance(sample, unbiased=True)
        sample_std = abs(sample_variance) ** (1/2)
    else:
        sample_std = pop_std

    sample_mean = calc_sample_mean(sample)
    difference_from_the_sample = z * (sample_std/(len(sample)**(1/2)))
    conf_interval = [sample_mean - difference_from_the_sample, sample_mean + difference_from_the_sample]
    return conf_interval


# %% Experiments

# Generate the two populations of size 1000000, calculate and print their means
# and variances and plot the population histograms.
M = 1000000
k_1 = 2.1
k_2 = 3.7
conf_lvl = 97

# YOUR CODE HERE
population_1 = gen_inverse(k_1, M)
population_2 = gen_rejection(k_2, M)
mean_of_population_1 = calc_population_mean(k_1)
print("Mean of the first population is:" + str(mean_of_population_1))
mean_of_population_2 = calc_population_mean(k_2)
print("Mean of the second population is:" + str(mean_of_population_2))
variance_of_population_1 = calc_population_variance(k_1)
print("Variance of the first population is:" + str(variance_of_population_1))
variance_of_population_2 = calc_population_variance(k_2)
print("Variance of the second population is:" + str(variance_of_population_2))

plt.figure()
# YOUR CODE HERE
plt.hist(population_1,100, color='black')
plt.ylim(0, 100000)
plt.title("Histogram of Population 1")
plt.figure()
plt.hist(population_2,100, color='orange')
plt.ylim(0, 100000)
plt.title("Histogram of Population 2")

# Collect 100000 random samples of size 25 from both populations, calculate
# sample means, biased and unbiased sample variances, MoM and MLE estimates of
# the parameter k and population mean intervals with 97% confidence with and
# without the population standard deviation for each sample of each population.
N = 25
R = 100000

# YOUR CODE HERE
samples_1 = []
for i in range(R):
    samples_1.append(random_sample(population_1, N))

samples_2 = []
for i in range(R):
    samples_2.append(random_sample(population_2, N))

sample_means_1 = []
sample_means_2 = []
biased_sample_variances_1= []
biased_sample_variances_2= []
unbiased_sample_variances_1 = []
unbiased_sample_variances_2 = []
k_1s_with_mom = []
k_2s_with_mom = []
k_1s_with_mle = []
k_2s_with_mle = []
confidence_intervals_1 = []
confidence_intervals_2 = []

for i in range(R):
    sample_means_1.append(calc_sample_mean(samples_1[i]))
    sample_means_2.append(calc_sample_mean(samples_2[i]))
    biased_sample_variances_1.append(calc_sample_variance(samples_1[i], unbiased=False))
    biased_sample_variances_2.append(calc_sample_variance(samples_2[i], unbiased=False))
    unbiased_sample_variances_1.append(calc_sample_variance(samples_1[i], unbiased=True))
    unbiased_sample_variances_2.append(calc_sample_variance(samples_2[i], unbiased=True))
    k_1s_with_mom.append(estimate_k_mom(samples_1[i]))
    k_2s_with_mom.append(estimate_k_mom(samples_2[i]))
    k_1s_with_mle.append(estimate_k_mle(samples_1[i]))
    k_2s_with_mle.append(estimate_k_mle(samples_2[i]))
    confidence_intervals_1.append(calc_conf_int_mean(samples_1[i], 97))
    confidence_intervals_2.append(calc_conf_int_mean(samples_2[i], 97))

# Calculate and print means of sample means, biased and unbiased sample
# variances, MoM and MLE estimates of parameter k and plot the histograms of
# sample means, k estimates using MoM and MLE for both populations.

# YOUR CODE HERE
total_of_sample_means_1 = 0
total_of_sample_means_2 = 0
total_of_biased_sample_variances_1 = 0
total_of_biased_sample_variances_2 = 0
total_of_unbiased_sample_variances_1 = 0
total_of_unbiased_sample_variances_2 = 0
total_of_k_1s_with_mom = 0
total_of_k_2s_with_mom = 0
total_of_k_1s_with_mle = 0
total_of_k_2s_with_mle = 0

for i in range(R):
    total_of_sample_means_1 += sample_means_1[i]
    total_of_sample_means_2 += sample_means_2[i]
    total_of_biased_sample_variances_1 += biased_sample_variances_1[i]
    total_of_biased_sample_variances_2 += biased_sample_variances_2[i]
    total_of_unbiased_sample_variances_1 += unbiased_sample_variances_1[i]
    total_of_unbiased_sample_variances_2 += unbiased_sample_variances_2[i]
    total_of_k_1s_with_mom += k_1s_with_mom[i]
    total_of_k_2s_with_mom += k_2s_with_mom[i]
    total_of_k_1s_with_mle += k_1s_with_mle[i]
    total_of_k_2s_with_mle += k_2s_with_mle[i]

mean_of_sample_means_1 = total_of_sample_means_1 / len(samples_1)
mean_of_sample_means_2 = total_of_sample_means_2 / len(samples_2)
mean_of_biased_sample_variances_1 = total_of_biased_sample_variances_1 / len(samples_1)
mean_of_biased_sample_variances_2 = total_of_biased_sample_variances_2 / len(samples_2)
mean_of_unbiased_sample_variances_1 = total_of_unbiased_sample_variances_1 / len(samples_1)
mean_of_unbiased_sample_variances_2 = total_of_unbiased_sample_variances_2 / len(samples_2)
mean_of_k_1s_with_mom = total_of_k_1s_with_mom / len(samples_1)
mean_of_k_2s_with_mom = total_of_k_2s_with_mom / len(samples_2)
mean_of_k_1s_with_mle = total_of_k_1s_with_mle / len(samples_1)
mean_of_k_2s_with_mle = total_of_k_2s_with_mle / len(samples_2)

print("The mean of sample means from samples 1 is: " + str(mean_of_sample_means_1))
print("The mean of sample means from samples 2 is: " + str(mean_of_sample_means_2))
print("The mean of biased sample variances from samples 1 is: " + str(mean_of_biased_sample_variances_1))
print("The mean of biased sample variances from samples 2 is: " + str(mean_of_biased_sample_variances_2))
print("The mean of unbiased sample variances from samples 1 is: " + str(mean_of_unbiased_sample_variances_1))
print("The mean of unbiased sample variances from samples 2 is: " + str(mean_of_unbiased_sample_variances_2))
print("The mean of k estimates for samples 1 with MoM is: " + str(mean_of_k_1s_with_mom))
print("The mean of k estimates for samples 2 with MoM is: " + str(mean_of_k_2s_with_mom))
print("The mean of k estimates for samples 1 with MLE is: " + str(mean_of_k_1s_with_mle))
print("The mean of k estimates for samples 2 with MLE is: " + str(mean_of_k_2s_with_mle))

plt.figure()
# YOUR CODE HERE
plt.hist(sample_means_1,100, color='black')
plt.xlim(0,1)
plt.ylim(0, 5000)
plt.title("Sample Means of Sample 1")
plt.figure()
plt.hist(sample_means_2,100, color='orange')
plt.xlim(0,1)
plt.ylim(0, 5000)
plt.title("Sample Means of Sample 2")

plt.figure()
# YOUR CODE HERE
plt.hist(k_1s_with_mom,100, color='black')
plt.xlim(0,12)
plt.ylim(0, 6000)
plt.title("k estimation of sample 1 with MoM")
plt.figure()
plt.hist(k_1s_with_mle,100, color='orange')
plt.xlim(0,12)
plt.ylim(0, 6000)
plt.title("k estimation of sample 1 with MLE")

plt.figure()
# YOUR CODE HERE
plt.hist(k_2s_with_mom,100, color='black')
plt.xlim(0,12)
plt.ylim(0, 6000)
plt.title("k estimation of sample 2 with MoM")
plt.figure()
plt.hist(k_2s_with_mle,100, color='orange')
plt.xlim(0,12)
plt.ylim(0, 6000)
plt.title("k estimation of sample 2 with MLE")


# Calculate and print the ratio of confidence intervals computed with and
# without using the population standard deviation that contains the population
# mean for both populations.

# YOUR CODE HERE
num_of_intervals_has_mean_1 = 0
num_of_intervals_1 = 0
num_of_intervals_has_mean_2 = 0
num_of_intervals_2 = 0

pop_1_std_deviation = (variance_of_population_1**(1/2))
pop_2_std_deviation = (variance_of_population_2**(1/2))

for i in range(R):
    conf_int_with_std_deviation_95 = calc_conf_int_mean(samples_1[i], 95, pop_1_std_deviation)
    if mean_of_population_1 <= conf_int_with_std_deviation_95[1] and mean_of_population_1 >= conf_int_with_std_deviation_95[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_without_std_deviation_95 = calc_conf_int_mean(samples_1[i], 95)
    if mean_of_population_1 <= conf_int_without_std_deviation_95[1] and mean_of_population_1 >= conf_int_without_std_deviation_95[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_with_std_deviation_96 = calc_conf_int_mean(samples_1[i], 96, pop_1_std_deviation)
    if mean_of_population_1 <= conf_int_with_std_deviation_96[1] and mean_of_population_1 >= conf_int_with_std_deviation_96[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_without_std_deviation_96 = calc_conf_int_mean(samples_1[i], 96)
    if mean_of_population_1 <= conf_int_without_std_deviation_96[1] and mean_of_population_1 >= conf_int_without_std_deviation_96[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_with_std_deviation_97 = calc_conf_int_mean(samples_1[i], 97, pop_1_std_deviation)
    if mean_of_population_1 <= conf_int_with_std_deviation_97[1] and mean_of_population_1 >= conf_int_with_std_deviation_97[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_without_std_deviation_97 = calc_conf_int_mean(samples_1[i], 97)
    if mean_of_population_1 <= conf_int_without_std_deviation_97[1] and mean_of_population_1  >= conf_int_without_std_deviation_97[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_with_std_deviation_98 = calc_conf_int_mean(samples_1[i], 98, pop_1_std_deviation)
    if mean_of_population_1 <= conf_int_with_std_deviation_98[1] and mean_of_population_1 >= conf_int_with_std_deviation_98[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_without_std_deviation_98 = calc_conf_int_mean(samples_1[i], 98)
    if mean_of_population_1 <= conf_int_without_std_deviation_98[1] and mean_of_population_1 >= conf_int_without_std_deviation_98[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_with_std_deviation_99 = calc_conf_int_mean(samples_1[i], 99, pop_1_std_deviation)
    if mean_of_population_1 <= conf_int_with_std_deviation_99[1] and mean_of_population_1 >= conf_int_with_std_deviation_99[0]:
        num_of_intervals_has_mean_1 += 1

    conf_int_without_std_deviation_99 = calc_conf_int_mean(samples_1[i], 99)
    if mean_of_population_1 <= conf_int_without_std_deviation_99[1] and mean_of_population_1 >= conf_int_without_std_deviation_99[0]:
        num_of_intervals_has_mean_1 += 1

    num_of_intervals_1 += 10

ratio_1 = num_of_intervals_has_mean_1 / num_of_intervals_1
print("According to confidence interval calculations, the ratio between the number of confidence intervals\n" +
      "that has population standard deviation in it to the total number of confidence intervals for population 1 is:"
      + str(ratio_1))

for i in range(R):
    conf_int_with_std_deviation_95 = calc_conf_int_mean(samples_2[i], 95, pop_2_std_deviation)
    if mean_of_population_2 <= conf_int_with_std_deviation_95[1] and mean_of_population_2 >= conf_int_with_std_deviation_95[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_without_std_deviation_95 = calc_conf_int_mean(samples_2[i], 95)
    if mean_of_population_2 <= conf_int_without_std_deviation_95[1] and mean_of_population_2 >= conf_int_without_std_deviation_95[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_with_std_deviation_96 = calc_conf_int_mean(samples_2[i], 96, pop_2_std_deviation)
    if mean_of_population_2 <= conf_int_with_std_deviation_96[1] and mean_of_population_2 >= conf_int_with_std_deviation_96[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_without_std_deviation_96 = calc_conf_int_mean(samples_2[i], 96)
    if mean_of_population_2 <= conf_int_without_std_deviation_96[1] and mean_of_population_2 >= conf_int_without_std_deviation_96[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_with_std_deviation_97 = calc_conf_int_mean(samples_2[i], 97, pop_2_std_deviation)
    if mean_of_population_2 <= conf_int_with_std_deviation_97[1] and mean_of_population_2 >= conf_int_with_std_deviation_97[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_without_std_deviation_97 = calc_conf_int_mean(samples_2[i], 97)
    if mean_of_population_2 <= conf_int_without_std_deviation_97[1] and mean_of_population_2 >= conf_int_without_std_deviation_97[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_with_std_deviation_98 = calc_conf_int_mean(samples_2[i], 98, pop_2_std_deviation)
    if mean_of_population_2 <= conf_int_with_std_deviation_98[1] and mean_of_population_2 >= conf_int_with_std_deviation_98[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_without_std_deviation_98 = calc_conf_int_mean(samples_2[i], 98)
    if mean_of_population_2 <= conf_int_without_std_deviation_98[1] and mean_of_population_2 >= conf_int_without_std_deviation_98[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_with_std_deviation_99 = calc_conf_int_mean(samples_2[i], 99, pop_2_std_deviation)
    if mean_of_population_2 <= conf_int_with_std_deviation_99[1] and mean_of_population_2 >= conf_int_with_std_deviation_99[0]:
        num_of_intervals_has_mean_2 += 1

    conf_int_without_std_deviation_99 = calc_conf_int_mean(samples_2[i], 99)
    if mean_of_population_2 <= conf_int_without_std_deviation_99[1] and mean_of_population_2 >= conf_int_without_std_deviation_99[0]:
        num_of_intervals_has_mean_2 += 1

    num_of_intervals_2 += 10

ratio_2 = num_of_intervals_has_mean_2 / num_of_intervals_2
print("According to confidence interval calculations, the ratio between the number of confidence intervals\n" +
      "that has population standard deviation in it to the total number of confidence intervals for population 2 is:"
      + str(ratio_2))


print('*'*50)
# Collect a sample of length 100000*25 from both populations, calculate and
# print their sample means, biased and unbiased sample variances, MoM and MLE
# estimates of parameter k and confidence intervals with and without using the
# population standard deviation.

# YOUR CODE HERE
sample_1 = random_sample(population_1, 2500000)
sample_2 = random_sample(population_2, 2500000)

sample_mean_1 = calc_sample_mean(sample_1)
sample_mean_2 = calc_sample_mean(sample_2)

biased_sample_variance_1 = calc_sample_variance(sample_1, False)
biased_sample_variance_2 = calc_sample_variance(sample_2, False)
unbiased_sample_variance_1 = calc_sample_variance(sample_1)
unbiased_sample_variance_2 = calc_sample_variance(sample_2)

k_for_sample_1_with_mom = estimate_k_mom(sample_1)
k_for_sample_2_with_mom = estimate_k_mom(sample_2)
k_for_sample_1_with_mle = estimate_k_mle(sample_1)
k_for_sample_2_with_mle = estimate_k_mle(sample_2)

conf_int_for_sample_1_with_std_deviation_95 = calc_conf_int_mean(sample_1, 95, pop_1_std_deviation)
conf_int_for_sample_1_without_std_deviation_95 = calc_conf_int_mean(sample_1, 95)
conf_int_for_sample_1_with_std_deviation_96 = calc_conf_int_mean(sample_1, 96, pop_1_std_deviation)
conf_int_for_sample_1_without_std_deviation_96 = calc_conf_int_mean(sample_1, 96)
conf_int_for_sample_1_with_std_deviation_97 = calc_conf_int_mean(sample_1, 97, pop_1_std_deviation)
conf_int_for_sample_1_without_std_deviation_97 = calc_conf_int_mean(sample_1, 97)
conf_int_for_sample_1_with_std_deviation_98 = calc_conf_int_mean(sample_1, 98, pop_1_std_deviation)
conf_int_for_sample_1_without_std_deviation_98 = calc_conf_int_mean(sample_1, 98)
conf_int_for_sample_1_with_std_deviation_99 = calc_conf_int_mean(sample_1, 99, pop_1_std_deviation)
conf_int_for_sample_1_without_std_deviation_99 = calc_conf_int_mean(sample_1, 99)

conf_int_for_sample_2_with_std_deviation_95 = calc_conf_int_mean(sample_2, 95, pop_2_std_deviation)
conf_int_for_sample_2_without_std_deviation_95 = calc_conf_int_mean(sample_2, 95)
conf_int_for_sample_2_with_std_deviation_96 = calc_conf_int_mean(sample_2, 96, pop_2_std_deviation)
conf_int_for_sample_2_without_std_deviation_96 = calc_conf_int_mean(sample_2, 96)
conf_int_for_sample_2_with_std_deviation_97 = calc_conf_int_mean(sample_2, 97, pop_2_std_deviation)
conf_int_for_sample_2_without_std_deviation_97 = calc_conf_int_mean(sample_2, 97)
conf_int_for_sample_2_with_std_deviation_98 = calc_conf_int_mean(sample_2, 98, pop_2_std_deviation)
conf_int_for_sample_2_without_std_deviation_98 = calc_conf_int_mean(sample_2, 98)
conf_int_for_sample_2_with_std_deviation_99 = calc_conf_int_mean(sample_2, 99, pop_2_std_deviation)
conf_int_for_sample_2_without_std_deviation_99 = calc_conf_int_mean(sample_2, 99)

print("The sample mean of sample 1 is: " + str(sample_mean_1))
print("The sample mean of sample 2 is: " + str(sample_mean_2))
print("The biased sample variance of sample 1 is: " + str(biased_sample_variance_1))
print("The biased sample variance of sample 2 is: " + str(biased_sample_variance_2))
print("The unbiased sample variance of sample 1 is: " + str(unbiased_sample_variance_1))
print("The unbiased sample variance of sample 2 is: " + str(unbiased_sample_variance_2))
print("The k estimate for sample 1 with MoM is: " + str(k_for_sample_1_with_mom))
print("The k estimate for sample 2 with MoM is: " + str(k_for_sample_2_with_mom))
print("The k estimate for sample 1 with MLE is: " + str(k_for_sample_1_with_mle))
print("The k estimate for sample 2 with MLE is: " + str(k_for_sample_2_with_mle))
print("The confidence interval of sample 1 with 95% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_1_with_std_deviation_95))
print("The confidence interval of sample 1 with 95% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_1_without_std_deviation_95))
print("The confidence interval of sample 1 with 96% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_1_with_std_deviation_96))
print("The confidence interval of sample 1 with 96% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_1_without_std_deviation_96))
print("The confidence interval of sample 1 with 97% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_1_with_std_deviation_97))
print("The confidence interval of sample 1 with 97% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_1_without_std_deviation_97))
print("The confidence interval of sample 1 with 98% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_1_with_std_deviation_98))
print("The confidence interval of sample 1 with 98% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_1_without_std_deviation_98))
print("The confidence interval of sample 1 with 99% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_1_with_std_deviation_99))
print("The confidence interval of sample 1 with 99% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_1_without_std_deviation_99))
print("The confidence interval of sample 2 with 95% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_2_with_std_deviation_95))
print("The confidence interval of sample 2 with 95% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_2_without_std_deviation_95))
print("The confidence interval of sample 2 with 96% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_2_with_std_deviation_96))
print("The confidence interval of sample 2 with 96% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_2_without_std_deviation_96))
print("The confidence interval of sample 2 with 97% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_2_with_std_deviation_97))
print("The confidence interval of sample 2 with 97% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_2_without_std_deviation_97))
print("The confidence interval of sample 2 with 98% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_2_with_std_deviation_98))
print("The confidence interval of sample 2 with 98% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_2_without_std_deviation_98))
print("The confidence interval of sample 2 with 99% confidence that is calculated with population standard deviation is: "
      + str(conf_int_for_sample_2_with_std_deviation_99))
print("The confidence interval of sample 2 with 99% confidence that is calculated without population standard deviation is: "
      + str(conf_int_for_sample_2_without_std_deviation_99))







plt.show()
plt.close()