(() => {
	const arrayA = [1, 2, 3, 4];
	const arrayB = [20, -4, 10, 3, 5];
	const target = 7;

	const solutionV1 = (
		arrA: number[],
		arrB: number[],
		target: number,
	): Map<number, number> => {
		const result = new Map();

		for (let numA of arrA) {
			for (let numB of arrB) {
				if (numA + numB == target) {
					result.set(numA, numB);
				}
			}
		}
		return result;
	};

	const solutionV2 = (
		arrA: number[],
		arrB: number[],
		target: number,
	): Map<number, number> => {
		const result = new Map();

		for (let numA of arrA) {
			const remain = target - numA;

			for (let numB of arrB) {
				if (numB == remain) {
					result.set(numA, numB);
				}
			}
		}
		return result;
	};

	const solutionV3 = (
		arrA: number[],
		arrB: number[],
		target: number,
	): Map<number, number> => {
		const result = new Map();
		const mem = new Set();

		for (let numB of arrB) {
			mem.add(numB);
		}

		for (let numA of arrA) {
			const remain = target - numA;
			if (mem.has(remain)) {
				result.set(numA, remain);
			}
		}
		return result;
	};

	// console.log(solutionV1(arrayA, arrayB, target));
	// console.log(solutionV2(arrayA, arrayB, target));
	console.log(solutionV3(arrayA, arrayB, target));
})();
