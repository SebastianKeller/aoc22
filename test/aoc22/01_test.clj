(ns aoc22.01-test
  (:require [aoc22.01 :refer :all]
            [clojure.test :refer :all]))

(def test-input (slurp "inputs/01-test.txt"))

(deftest part1
  (is (= 24000 (solution-1 test-input))))

(deftest part2
  (is (= 45000 (solution-2 test-input))))
