<h2> Recursion
</h2>

---

#### 개념

- 범위가 작아지면 작아질수록 각 조각달의 형태가 유사해지는 작업들을 구현할 때 유용하게 사용

- 자신이 수행할 작업을 유사한 형태의 여러 조각으로 쪼갠 뒤 그중 한 조각을 수행하고 나머지를 자기 자신을 호출해 실행하는 함수

#### 조건

- 모든 재귀 함수는 '더이상 쪼개지지 않는' 최소한의 작업에 도달했을 때 답을 곧장 반환하는 조건문을 포함해야한다. 이때 쪼개지지 않는 가장 작은 작업들을 가리켜 재귀 호출의 기저사례라고 한다.               
- 기저사례를 선택할 떄는 존재하는 모든 입력이 항상 기저 사례의 답을 이용해 계산될 수 있도록 신경 써야 한다.

ex) 중첩 반복문 대체하기

```c++
for(int i=0;i<n;++i)
	for(int j=i+1;j<n;++j)
		for(int k=j+1;k<n;++k)
			for(int l=k+1;l<n;++l)
				cout<<i<<" "<<j<<" "<<k<<" "<<l<<endl;
```

* 위 코드 조각이 하는 작업을 네 개의 조각으로 나눌 수 있다.
* 각 조각에서 하나의 원소를 고른 것이다.
* 이렇게 원소를 고른 뒤, 남은 원소들을 고르는 작업을 자기 자신을 호출해 떠넘기는 재귀 함수를 작성해보자.

```c++
void pick(int n, vector<int>&picked,int toPick){
	if(toPick==0){printPicked(picked);return;}
	int smallest=picked.empty()?0:picked.back()+1;
	for(int next=smallest;next<n;++next){
		picked.push_back(next);
		pick(n,picked,toPick-1);
		picked.pop_back();
	}
}
```

  



간결한 코드를 작성하는 유용한 팁 : 입력이 잘못되거나 범위에서 벗어난 경우도 기저 사례로 택해서 맨 처음에 처리하는 것이다.

재귀함수는 항상 한군데 이상에서 호출되기 때문에 이습관은 반복적인 코드를 제거하는데 큰 도움이 된다.