#!/bin/bash

# 判断参数的个数
if [$# -lt 1]; then
  echo Not Enough Argument!
  exit
fi

# 遍历集群的所有机器
for host in node101 node102; do
  echo ========= $host =========
  for file in $@; do
    if [-e $file]; then
      pdir=$(
        cd -P $(dirname $file)
        pwd
      )
      fname=$(basename $file)
      ssh $host "mkdir -p $pdir"
      rsync -av $pdir/$fname $host:$pdir
    else
      echo $file dose not exists!
    fi
  done
done
