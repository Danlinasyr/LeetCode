/*

f[i][j] is the max value get when only considers the first i items, the total volume of these items is j

result = max(f[n][0-V])

f[i][j] : 

1. not choosing the ith item  f[j][j] = f[i - 1][j];
2. chooing the ith item    f[i][j] = f[i - 1][j - v[i]] + w[i]

f[j][j] = max(1.  2.);


f[0][0] = 0;

*/

#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int f[N][N];   // global variable are saved in heap, initialize to zero, thus don't have to initialize f[0][0] = 0
int v[N], w[N];
int n, m;

int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) { // each item info start from line 2
        cin >> v[i] >> w[i];
    }
    
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            f[i][j] = f[i-1][j];
            if (j >= v[i]) {
                f[i][j] = max(f[i][j], f[i-1][j - v[i]] + w[i]);
            }
        }
    }
    int res = 0;
    for (int i = 0; i <= m; i++) {
        res = max(res, f[n][i]);
    }
    
    cout << res << endl;
    return 0;
}




/*

f[i] is the max value get when volume is i

result = max(f[n][0-V])

chooing the ith item    f[i][j] = f[i - 1][j - v[i]] + w[i]

f[j][j] = max(1.  2.);


f[0][0] = 0;

*/

#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1010;

int f[N];  // all indices have been initialized to zero
int v[N], w[N];
int n, m;

int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) { // each item info start from line 2
        cin >> v[i] >> w[i];
    }
    
    for (int i = 1; i <= n; i++) {
        for (int j = m; j >= v[i]; j--) {
            f[j] = max(f[j], f[j - v[i]] + w[i]);
        }
    }

/*

f[0] = 0;
f[i] = 0;

k < m
f[k] = max_w;

f[0] = 0 -> f[v[0]] = w[0] ->
f[m - k] = 0 -> f[m - k + v[0]] = w[0] ->


*/


    cout << f[m] << endl;
    return 0;
}
