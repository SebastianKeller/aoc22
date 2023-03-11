(ns aoc22.03-test
  (:require [aoc22.03 :refer :all]
            [clojure.test :refer :all]
            [criterium.core :as c]))


(def input (slurp "inputs/03-test.txt"))

(deftest test-part-1
  (is (= 157 (part-1 input))))

(deftest test-part-2
  (is (= 70 (part-2 input))))
