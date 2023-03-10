(ns aoc22.02-test
  (:require [aoc22.02 :refer :all]
            [clojure.test :refer :all]
            [criterium.core :as c]))

(def input (slurp "inputs/02-test.txt"))

(deftest part1
  (is (= 15 (solution-1 input))))

(deftest part2
  (is (= 12 (solution-2 input))))
